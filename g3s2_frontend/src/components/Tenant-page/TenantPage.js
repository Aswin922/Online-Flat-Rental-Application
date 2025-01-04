import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';


import Header from '../Tenant-page/Header';
import Menu from '../Tenant-page/Menu';
import Footer from '../Tenant-page/Footer';




function Tenant() {

   return (
      <React.Fragment>

              
    <div className="container mt-2">
      {/* <AddFlatBooking /> */}
      <Header />
      <Menu />  

      <Footer />
    </div>
      </React.Fragment>
    );
}

export default Tenant;