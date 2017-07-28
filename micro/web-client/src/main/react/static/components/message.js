import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
// import { bindActionCreators } from 'redux';
import { fetchHello } from '../actions/setHello';

const Message = (props) => (
        <div className="message">
            { props.message }
            <button type="button" onClick={props.onUpdateClick}>Update()</button>
        </div>
);

Message.propTypes = {
    message: PropTypes.string.isRequired,
    onUpdateClick: PropTypes.func.isRequired
};


function mapStateToProps(state) {
    return { message: state.message };
}

function mapDispatchToProps(dispatch) {
    return {
        onUpdateClick: () => {
            dispatch(fetchHello());
        }
    };
}


export default connect(mapStateToProps, mapDispatchToProps)(Message);
