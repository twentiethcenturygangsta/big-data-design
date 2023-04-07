import React from 'react'
import { cardStyle, fontStyle, info } from './index.css'
import Button from '../../components/button'
interface CardProps {
  name: string
  title: string
  amount: number
  ImageSrc: string
  altString: string
}

const Card = ({ name, title, amount, ImageSrc, altString }: CardProps) => {
  return (
    <div className={cardStyle}>
      <img src={ImageSrc} alt={altString}></img>
      <div className={info}>
        <span className={fontStyle}>{name}</span>
        <p className={fontStyle}>{title}</p>
        <p className={fontStyle}>{amount} 개</p>
      </div>
      <Button ariaLabel="버튼" onClick={() => console.log('a')}>
        구매
      </Button>
    </div>
  )
}

export default Card
