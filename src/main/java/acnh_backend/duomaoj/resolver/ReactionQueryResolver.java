package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Reaction;
import acnh_backend.duomaoj.repository.ReactionRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ReactionQueryResolver implements GraphQLQueryResolver {
    private ReactionRepository reactionRepository;

    public ReactionQueryResolver(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public Iterable<Reaction> findAllReactions() {
        return reactionRepository.findAll();
    }

    public Reaction findReactionById(String id) {
        ObjectId oid = new ObjectId(id);
        return reactionRepository.findReactionById(oid);
    }
}
