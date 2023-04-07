import { style } from '@vanilla-extract/css'
import { vars } from 'styles/theme.css'

export const cardStyle = style({
  display: 'flex',
  width: '100%',
  alignItems: 'center',
  flexDirection: 'column',
  justifyContent: 'column',
  borderRadius: '0.5rem',
  padding: '0.625rem',
  boxShadow: '0 0.5rem 1rem rgba(0, 0, 0, 0.1)',
  maxWidth: '18.75rem',
})

export const info = style({
  display: 'flex',
  width: '100%',
  padding: '0.375rem',
})

export const fontStyle = style({
  textAlign: 'center',
})
