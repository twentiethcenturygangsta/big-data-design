import { style } from '@vanilla-extract/css'
import { vars } from '../../styles/theme.css'

export const headerStyles = style({
  position: 'sticky',
  top: 0,
  display: 'flex',
  justifyContent: 'space-between',
  alignItems: 'center',
  padding: '0.625rem 1.25rem',
  backgroundColor: vars.colors.text.normal,
  color: vars.colors.primary,
  fontWeight: 'bold',
})
