import React, { MouseEventHandler, ReactNode } from 'react'
import { buttonStyle } from './index.css'

interface ButtonProps {
  children: ReactNode
  ariaLabel: string
  onClick?: MouseEventHandler<HTMLButtonElement>
}

const Button = ({ children, ariaLabel, onClick }: ButtonProps) => {
  return (
    <button className={buttonStyle} aria-label={ariaLabel} onClick={onClick}>
      {children}
    </button>
  )
}

export default Button
