import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  // Removed StrictMode to avoid components being rendered twice. 
  // See: https://mariosfakiolas.com/blog/my-react-components-render-twice-and-drive-me-crazy/
  // <React.StrictMode>
    <App />
  // </React.StrictMode>
)
