import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListCarComponent from './components/ListCarComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateCarComponent from './components/CreateCarComponent';
import ViewCarComponent from './components/ViewCarComponent';
import UpdateCarComponent from './components/UpdateCarComponent';


function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={ListCarComponent}></Route>
            <Route path="/cars" component={ListCarComponent}></Route>
            <Route path="/add-car/:id" component={CreateCarComponent}></Route>
            <Route path="/view-car/:id" component={ViewCarComponent}></Route>
            <Route path="/update-car/:id" component={UpdateCarComponent}></Route>
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>

  );
}

export default App;
