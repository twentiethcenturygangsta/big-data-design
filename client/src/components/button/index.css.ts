import { style } from '@vanilla-extract/css'
import { vars } from '../../styles/theme.css'

export const buttonStyle = style({
  border: 'none',
  borderRadius: '0.25rem',
  padding: '0.375rem 0.625rem',
  backgroundColor: vars.colors.primary,
  color: vars.colors.text.normal,
  cursor: 'pointer',
  transition: 'all 0.2s ease-in-out',
  ':hover': {
    backgroundColor: vars.colors.gray,
  },
})
