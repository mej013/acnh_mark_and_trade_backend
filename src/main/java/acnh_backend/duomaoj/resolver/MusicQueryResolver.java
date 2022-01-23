package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Music;
import acnh_backend.duomaoj.repository.MusicRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MusicQueryResolver implements GraphQLQueryResolver {
    private MusicRepository musicRepository;

    public Iterable<Music> findAllMusic() {
        return musicRepository.findAll();
    }

    public Music findMusicById(String id) {
        ObjectId oid = new ObjectId(id);
        return musicRepository.findMusicById(oid);
    }

    public Music findMusicByName(String name) {
        return musicRepository.findMusicByName(name);
    }
}
