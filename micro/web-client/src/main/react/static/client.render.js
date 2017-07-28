/*eslint-disable*/
import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter} from 'react-router';
import { createStore, applyMiddleware } from 'redux';
import thunkMiddleware from 'redux-thunk';
import { Provider } from 'react-redux';
import app from './reducers/app';
import App from './App';
// import { fetchHello } from './actions/setHello';

console.log(window.__PRELOADED_STATE__);

const appStore = createStore(
    app,
    window.__PRELOADED_STATE__,
    applyMiddleware(
        thunkMiddleware
    )
);

ReactDOM.render(<Provider store={appStore}><BrowserRouter><App /></BrowserRouter></Provider>, document.getElementById('app'));

