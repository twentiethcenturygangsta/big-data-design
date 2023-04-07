import { createVar, style, styleVariants } from '@vanilla-extract/css'
import { vars } from './theme.css'

export const mainContainer = style({
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  background: vars.colors.secondary,
  flexWrap: 'wrap',
  padding: '1.875rem 6.25rem',
  gap: '2.5rem',
})
