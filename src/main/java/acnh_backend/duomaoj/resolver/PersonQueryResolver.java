package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Person;
import acnh_backend.duomaoj.service.PersonService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonQueryResolver implements GraphQLQueryResolver {
    private final PersonService personService;

    public Person getPerson(String personId) {
        return personService.getById(personId);
    }
}
