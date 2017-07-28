import { POST_FORMAT_MESSAGE, RECEIVE_FORMAT_RESULT } from '../actions/format';

function format(state = { message: '', format: '' }, action) {
    switch (action.type) {
        case POST_FORMAT_MESSAGE:
            return Object.assign({}, state, {
                message: action.message,
                format: action.format
            });
        case RECEIVE_FORMAT_RESULT:
            return Object.assign({}, state, {
                result: action.result
            });
        default:
            return state;
    }
}

export default format;
