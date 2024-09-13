
import './../css/contentbox.css'

function ContentBox({title, src}) {
    return (
        <div className='contentBox'>
            {src && <img src={src} alt="" />}
            {title && <h3>{title}</h3>}
        </div>
    );
}

export default ContentBox;