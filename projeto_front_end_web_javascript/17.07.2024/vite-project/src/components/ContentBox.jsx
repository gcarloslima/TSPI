import './../css/contentBox.css'

function ContentBox({info}) {
    return (
        <div className='box'>
            <p>{info}</p>
        </div>
    ) 
}

export default ContentBox;