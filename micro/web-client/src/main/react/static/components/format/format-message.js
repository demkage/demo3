/*eslint-disable*/
import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { fetchFormatMessage } from '../../actions/format';

let data = {
}

const FormatMessage = (props) => {
    const placeholder = '';

    return (
        <form onSubmit={props.onSubmit}>
            <label htmlFor="message">
                Message:
                <input type="text" name="message" ref={(input) => data.message = input} />
            </label>

            <label htmlFor="format">
                Format:
                <input type="text" name="format" ref={(input) => data.format = input} />
            </label>

            <label htmlFor={props.result}>
                Result: {props.result}
            </label>

            <input type="submit" name="submit" />
            {placeholder}
        </form>
    );
};

FormatMessage.propTypes = {
    message: PropTypes.string.isRequired,
    format: PropTypes.string.isRequired,
    result: PropTypes.string.isRequired,
    onSubmit: PropTypes.func.isRequired
};

function mapStateToProps(state) {
    console.log(state);

    return {
        result: state.format.result
    };
}

function mapDispatchToProps(dispatch) {
    return {
        onSubmit: (e) => {
            e.preventDefault();
            dispatch(fetchFormatMessage({ message: data.message.value, format: data.format.value }));
        }
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(FormatMessage);
