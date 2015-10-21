package empire.demo.services;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import empire.demo.model.AccDTO;
import empire.demo.model.Provider;

public interface ProviderRepository  extends CrudRepository<Provider, Long> {
	
//    public Long countByDefinition(String definition);
//    public List<Provider> findByDefinition(String definition);
//    public List<Provider> findDistinctProviderByDefinition(String definition);
//    public List<Provider> findDistinctProvider();
    
    @Query("select distinct p.definition from Provider p")
    public List<String> findDistinctProviderDefinitions();
    
    @Query("select new empire.demo.model.AccDTO(SUM(p.avgCoveredCharges) / COUNT(p.providerState), p.providerState) from Provider p where p.definition = :definition" +
    		" group by p.providerState order by p.providerState")
    public List<AccDTO> findAverageAcc(@Param("definition") String definition);
}
 