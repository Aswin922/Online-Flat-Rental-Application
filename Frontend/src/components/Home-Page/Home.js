import React, { useEffect, useState } from 'react';
import styles from '../Home-Page/home.module.css';
import {Link} from 'react-router-dom';

function Home() {

   return (
      <React.Fragment>
            <div className={styles.cont}>
            <div className={styles.coch1}>
                <c data-text= "Online Flat Rental"><b>Online Flat Rental</b></c>
                <button id="formlogin" className={styles.getStarted}><Link to="/login" >Get Started &gt;&gt;&gt;</Link></button>
                
            </div>
        </div>
      </React.Fragment>
    );
}

export default Home;