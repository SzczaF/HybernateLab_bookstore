package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherDao publisherDao;
    private final PublisherRepository publisherRepository;

    public void save(Publisher publisher){
        publisherDao.save(publisher);
    }

    public Publisher findById(long id){
        return publisherDao.findById(id);
    }

    public void update(Publisher publisher){
        publisherDao.update(publisher);
    }

    public void delete(Publisher publisher){
        publisherDao.delete(publisher);
    }
    public List<Publisher> all(){
        return publisherDao.all();
    }

    public Publisher getPublisherByNip(String nip){
        return publisherRepository.findFirstPublishersByNip(nip);
    }

    public Publisher getPublisherByRegon(String regon) {
        return publisherRepository.findFirstPublishersByRegon(regon);
    }

}
