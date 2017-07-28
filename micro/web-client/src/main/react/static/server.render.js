/*eslint-disable*/
import React from 'react';
import { renderToString } from "react-dom/server";
import { StaticRouter } from 'react-router';
import { createStore, applyMiddleware } from 'redux';
import thunkMiddleware from 'redux-thunk';
import { Provider } from 'react-redux';
import serialize from 'serialize-javascript';
import app from './reducers/app';
import App from './App';


window.render = (template, model) => {
    const context = {};

    const req = JSON.parse(model.get('req'));

    const initialState = JSON.parse(model.get('state'));

    const store = createStore(app, initialState, applyMiddleware(thunkMiddleware));

    const markup = renderToString(
        <Provider store={store}>
            <StaticRouter location={req.location} context={context}>
                <App />
            </StaticRouter>
        </Provider>
    );

    return template
        .replace('SERVER_RENDERED_HTML', markup)
        .replace('SERVER_RENDERED_STATE', serialize(initialState, { isJSON: true } ));
}

