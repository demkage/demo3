import { combineReducers } from 'redux';
import hello from './hello';
import format from './format';


const app = combineReducers({
    hello,
    format
});

export default app;
