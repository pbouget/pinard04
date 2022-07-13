package fr.pinard.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.pinard.model.Vin;
import fr.pinard.model.Vin.choix;
import fr.pinard.model.VinPK;
import fr.pinard.repository.VinRepository;

/**
 * @author Philippe
 *
 */
@RestController
@CrossOrigin("*")
public class PinardController {
	
	@Autowired
	private VinRepository vinRepository;
	
	@GetMapping("/accueil")
	@ResponseBody
	public String home(){
		
		Vin v1=new Vin();
		VinPK pk1=new VinPK(777777,"Les Hauts du Tertre 2005");
        v1.setVinPK(pk1);
		v1.setRegion("Bordeaux (Margaux)");
		v1.setCouleur(choix.ROUGE);
		v1.setPrix(11.50);
		v1.setRemise(0);
		v1.setQuantite(2);

		Vin v2=new Vin();
		VinPK pk2=new VinPK(888888,"Château Marquis de Terme 1899");
		v2.setVinPK(pk2);
		v2.setRegion("Bordeaux (Margaux)");
		v2.setCouleur(choix.BLANC);
		v2.setPrix(19.00);
		v2.setRemise(0);
		v2.setQuantite(3);

		Vin v3=new Vin();
		VinPK pk3=new VinPK(999999,"Clos du Marquis 2007");
		v3.setVinPK(pk3);
		v3.setRegion("Bordeaux (Saint-Julien)");
		v3.setCouleur(choix.ROUGE);
		v3.setPrix(22.90);
		v3.setRemise(0);
		v3.setQuantite(15);

		Vin v4=new Vin();
		VinPK pk4=new VinPK(111111,"Clos du Baron 2015");
		v4.setVinPK(pk4);
		v4.setRegion("Bordeaux (Saint-Julien)");
		v4.setCouleur(choix.BLANC);
		v4.setPrix(45.20);
		v4.setRemise(0);
		v4.setQuantite(50);


		System.out.println("ajout du produit v1 : "+v1);
		ajoutVin(v1);

		System.out.println("ajout du produit v2 : "+v2);
		ajoutVin(v2);

		System.out.println("ajout du produit v3 : "+v3);
		v3=ajoutVin(v3);
		v3.setQuantite(10);
		updateVin(v3);

		System.out.println("ajout du produit v4 : "+v4);
		v4=ajoutVin(v4);

		updateQuantite(v4.getVinPK(),30);
		updateVin(v4);

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Regardez dans votre console et dans votre base de données MySQL <strong>JPA</strong></h1>");
		sb.append("<a href='http://localhost:8080/vins'>Voir la liste des vins enregistrés</a>");
		return  sb.toString();
	}

	

	public Optional<Vin> findById(VinPK vinPk){
		return vinRepository.findById(vinPk);
	}
	/**
	 * Retourne tous les produits dans une liste
	 */
	@GetMapping("/vins")
	public Collection<Vin> findAll(){

		return vinRepository.findAll();
	}
	/**
	 * Ajoute un vin
	 */
	public Vin ajoutVin(Vin vin){
		return vinRepository.save(vin);
	}
	/**
	 * Met un jour un enregistrement pour un objet Vin
	 */
	public Vin updateVin(Vin vin){
		return vinRepository.save(vin);
	}


	/**
	 * Met à jour la quantité d'un objet de type Vin
	 */
	public void updateQuantite(VinPK vinPk, int quantite){
		(vinRepository.getReferenceById(vinPk)).setQuantite(quantite);
	}


}
