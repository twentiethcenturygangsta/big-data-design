import React from 'react'
import ReactDOM from 'react-dom/client'
import './styles/global.css'
import reportWebVitals from './reportWebVitals'
import Main from './pages'

const root = ReactDOM.createRoot(document.getElementById('root') as HTMLElement)
root.render(
  <React.StrictMode>
    <Main />
  </React.StrictMode>,
)

reportWebVitals()
