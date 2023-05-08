import logo from './logo.svg';
import './App.css';
import ListCarComponent from './components/ListCarComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

function App() {
  return (
    <div>
      <HeaderComponent />
      <div className="container">
        <ListCarComponent />
      </div>
      <FooterComponent />
    </div>
  );
}

export default App;
