import {
  createGlobalTheme,
  createTheme,
  createThemeContract,
} from '@vanilla-extract/css'

export const vars = createGlobalTheme('#root', {
  space: {
    small: '4px',
    medium: '8px',
    large: '16px',
  },
  fonts: {
    heading: 'Georgia, Times, Times New Roman, serif',
    body: 'system-ui',
  },
  colors: {
    primary: '#eeeeee',
    secondary: '#FFFFFF',
    gray: '#9e9e9e',
    text: {
      normal: '#000000', // black
      dimmed: 'dedede', // lightgray
    },
  },
})
