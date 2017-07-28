// import { fetch } from 'isomorphic-fetch';

export const GET_HELLO = 'GET_HELLO';
export const RECEIVE_HELLO = 'RECEIVE_HELLO';

function requestHello() {
    return {
        type: GET_HELLO,
        startTime: Date.now()
    };
}


function receiveHello(message) {
    return {
        type: RECEIVE_HELLO,
        message,
        receivedAt: Date.now()
    };
}

export function fetchHello() {
    return function (dispatch) {
        dispatch(requestHello());

        // return dispatch(receiveHello('Fetch message'));
        return fetch('/api/hello/hi')
            .then(resp => resp.text())
            .then(data => dispatch(receiveHello(data)))
            .catch(error => console.log(error));
    };
}
