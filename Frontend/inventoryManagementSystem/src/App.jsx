/**
 * @file The top-level file for the Inventory Management System project frontend
 * @author Yucheng Zang <yzang7@wisc.edu>
 * @author Arnav Mangal <mangal3@wisc.edu>
 */

// External imports
import React from "react";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { useState } from "react";

// Internal imports
import MerchantNavbar from "./components/MerchantNavbar";
import InventoriesPage from "./pages/Inventories/InventoriesPage";
import UserTestPage from "./pages/UserTestPage/userPage";
// CSS imports
import "./App.css"
import 'bootstrap/dist/css/bootstrap.css';

function App() {
  return (
    <Router>
      <div className="App">
        <MerchantNavbar />
        <Routes>
          <Route exact path="/" element={<InventoriesPage />} />
          <Route path="/shopping" element={<UserTestPage />} /> {/* Route for ShoppingPage */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;