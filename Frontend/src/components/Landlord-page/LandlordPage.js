
import React from 'react';

import { BrowserRouter as Router,Route,Routes} from 'react-router-dom'

import Menu from '../Landlord-page/Menu';
import Footer from '../Landlord-page/Footer';
import Header from '../Landlord-page/Header';


function LandLord() {

   return (
      <React.Fragment>
        <Header/>
        <Menu/>
        <div className='container-fluid'>
        </div>
        <Footer/>
      </React.Fragment>
    );
}

export default LandLord;
