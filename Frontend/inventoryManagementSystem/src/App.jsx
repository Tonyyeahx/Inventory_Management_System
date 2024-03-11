/**
 * @file The top-level file for the Inventory Management System project frontend
 * @author Yucheng Zang <yzang7@wisc.edu>
 * @author Arnav Mangal <mangal3@wisc.edu>
 */

// External imports
import { useState } from "react"

// Internal imports
import MerchantNavbar from "./components/MerchantNavbar";
import InventoriesPage from "./pages/Inventories/InventoriesPage";

// CSS imports
import "./App.css"
import 'bootstrap/dist/css/bootstrap.css';

function App() {
  return (
    <div className="App">
      <MerchantNavbar />
      <InventoriesPage />
    </div>
  );
}

export default App
