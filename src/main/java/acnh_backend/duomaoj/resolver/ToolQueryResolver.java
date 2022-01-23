package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Tool;
import acnh_backend.duomaoj.repository.ToolRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ToolQueryResolver implements GraphQLQueryResolver {
    private ToolRepository toolRepository;
    public ToolQueryResolver(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public Iterable<Tool> findAllTools() {
        return toolRepository.findAll();
    }

    public Tool findToolById(String id) {
        ObjectId oid = new ObjectId(id);
        return toolRepository.findToolById(oid);
    }
}

