// import { combineReducers } from 'redux';
import { RECEIVE_HELLO, GET_HELLO } from '../actions/setHello';


function hello(state = { message: 'default', update: null }, action) {
    switch (action.type) {
        case RECEIVE_HELLO:
            return Object.assign({}, state, {
                message: action.message,
                update: action.receivedAt
            });

        case GET_HELLO:
            return Object.assign({}, state, {
                message: 'Loading...',
                update: Date.now()
            });

        default:
           return state;
    }
}


export default hello;
