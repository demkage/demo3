/*eslint-disable*/
import React from 'react';
import logo from './logo.svg';
import './App.css';
import FormatPage from './components/format/FormatPage';
import Message from './components/message'
import { Route, Link} from 'react-router-dom'

const App = () => (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <h2>Welcome to React</h2>
                    <ul>
                        <li><Link to="/">Home</Link></li>
                        <li><Link to="/parser">Parser</Link></li>
                    </ul>
                </div>
                <div className="App-header">
                    <Route exact path="/" component={Message} />
                    <Route path="/parser" component={FormatPage} />
                </div>
            </div>
);

export default App;
