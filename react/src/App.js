import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListCarComponent from './components/ListCarComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';


function App() {
  return (
    <div>
      <Router>
        <div className='container'>
          <HeaderComponent />
          <div className="container">
            <Switch>
              <Route path="/" component={ListCarComponent}></Route>
              <Route path="/cars" component={ListCarComponent}></Route>
              <ListCarComponent />
            </Switch>
          </div>
          <FooterComponent />
        </div>
      </Router>
    </div>
  );
}

export default App;
