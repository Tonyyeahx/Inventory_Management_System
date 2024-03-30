import React from "react";

// Indicates the view mode of the table, can be either 'View' or 'Edit'. 
// The value of this state variable is shared across all elements used by the InventoriesPage
const ViewModeContext = React.createContext([]);

export default ViewModeContext;
