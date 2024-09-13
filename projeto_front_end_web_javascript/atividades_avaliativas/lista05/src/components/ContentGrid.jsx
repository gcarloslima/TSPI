
import './../css/contentgrid.css'
import ContentBox from './ContentBox';

function ContentGrid({items}) {
    return (
        <div className='contentGrid'>
            {items.map((item, index) => (
                <ContentBox key={item.id} title={item.title} src={item.src} />
            ))}
        </div>
    );
}

export default ContentGrid;