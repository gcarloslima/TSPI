import React from 'react';
import './../css/titlebox.css'

function TitleBox({ title, description }) {
    return (
        <div className='titleBox'>
            <h2 className='boxTitle'>{title}</h2>
            <p className='boxDescription'>{description}</p>
        </div>
    );
}

export default TitleBox;