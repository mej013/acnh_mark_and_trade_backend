package acnh_backend.duomaoj.service;

import acnh_backend.duomaoj.model.Person;
import acnh_backend.duomaoj.repository.PersonRepository;
import acnh_backend.duomaoj.security.exception.PersonNotFoundException;
import acnh_backend.duomaoj.type.CreatePersonInput;
import acnh_backend.duomaoj.type.UpdatePersonInput;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    @Transactional
    public Person create(CreatePersonInput input) {
        return personRepository.save(Person
                .builder()
                .username(input.getUsername())
                .island_title(input.getIsland_title())
                .hemisphere(input.getHemisphere())
                .build()
        );
    }

    @Transactional
    public Person update(ObjectId _id, UpdatePersonInput input) {
        Person person = getById(_id.toString());
        person.setHemisphere(input.getHemisphere());
        person.setUsername(input.getUsername());
        person.setIsland_title(input.getIsland_title());
        return person;
    }

    @Transactional
    public Person updateMarked(String _id, List<Integer> marked) {
        Person person = getById(_id);
        person.setMarkedItems(marked);
        return personRepository.save(person);
    }

    @Transactional
    public boolean deletePerson(String id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public Person getById(String id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
