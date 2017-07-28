export const POST_FORMAT_MESSAGE = 'POST_FORMAT_MESSAGE';
export const RECEIVE_FORMAT_RESULT = 'RECEIVE_FORMAT_RESULT';

function postFormatMessage(data) {
    return {
        type: POST_FORMAT_MESSAGE,
        message: data.message,
        format: data.format
    };
}

function receiveResult(result) {
    return {
        type: RECEIVE_FORMAT_RESULT,
        result
    };
}

export function fetchFormatMessage(data) {
    return (dispatch) => {
        console.log(data);
        console.log(JSON.stringify(data));
        const post = {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        dispatch(postFormatMessage(data));

        return fetch('/api/parser/format', post)
            .then(resp => resp.text())
            .then(result => { console.log(result); return dispatch(receiveResult(result)); })
            .catch(error => console.log(error));
    };
}
