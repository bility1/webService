package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.DTO.CreneauDTO;
import services.DTO.RdvDTO;
import services.DTO.UtilDTO;
import services.DTO.UtilisateurDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DouDeuleProxy implements DouDeuleInterface {
    private static final String URI_SERVICE="http://localhost:8080/doudeule";

    private static final String RDV= "/rdv";
    private static final String UTILISATEUR = "/utilisateur";
    private static final String CRENEAU = "/creneau";
    private static final String DISPO = "/dispo";


    private HttpClient httpClient = HttpClient.newHttpClient();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<RdvDTO> getAllRdv() {
        return null;
    }

    @Override
    public int createRdv(RdvDTO rdv) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(rdv);
            HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(URI_SERVICE+RDV)).
                    header("Content-type","application/json").POST
                    (HttpRequest.BodyPublishers.ofString(json)).build();
            HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode()==201){
                String []location = response.headers().firstValue("location").get().split("/");
                return Integer.parseInt(location[location.length-1]);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnexpectedError("Creation de rendez-vous Impossible");
    }

    @Override
    public RdvDTO getRdv(int id) {
        return null;
    }

    @Override
    public int ajoutCreneau(int id, CreneauDTO c) {
        String json = null;
        try {
            /*
                Reconstruction d'un objet uitilisateur DTO à partir d'un string
                UtilisateurDTO = objectMapper.reader(UtilisateurDTO.class).readValue(json);

                Reconstruction d'une liste d'UtilisateurDTO à partir d'un String JSON

                objectMapper.readValue(json,objectMapper.getTypeFactory().constructCollectionType(List.class,UtilisateurDTO.class));
             */
            json = objectMapper.writeValueAsString(c);
            HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(URI_SERVICE+RDV+"/"+id+CRENEAU)).
                    header("Content-type","application/json").POST
                    (HttpRequest.BodyPublishers.ofString(json)).build();
            HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode()==201){
                String []location = response.headers().firstValue("location").get().split("/");
                return Integer.parseInt(location[location.length-1]);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnexpectedError("Ajout de creneau Impossible");
    }

    @Override
    public List<CreneauDTO> getCreneaux(int id) {
        return null;
    }

    @Override
    public void ajoutDispo(int idR, int idCreneau, UtilDTO udto) {
        String json = null;
        try {
            /*
                Reconstruction d'un objet uitilisateur DTO à partir d'un string
                UtilisateurDTO = objectMapper.reader(UtilisateurDTO.class).readValue(json);

                Reconstruction d'une liste d'UtilisateurDTO à partir d'un String JSON

                objectMapper.readValue(json,objectMapper.getTypeFactory().constructCollectionType(List.class,UtilisateurDTO.class));
             */
           //rdv/{idR}/creneau/{idC}/dispo
            json = objectMapper.writeValueAsString(udto);
            HttpRequest httpRequest= HttpRequest.newBuilder().uri(
                    URI.create(URI_SERVICE+RDV+"/"+idR+CRENEAU+"/"+idCreneau+DISPO)).
                    header("Content-type","application/json").PUT(HttpRequest.BodyPublishers.ofString(json)).build();
            HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode()==201){
                String []location = response.headers().firstValue("location").get().split("/");
                //return Integer.parseInt(location[location.length-1]);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnexpectedError("Rien de disponible ");

    }

    @Override
    public List<UtilisateurDTO> getAllUtils() {

//       HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URI_SERVICE+UTILISATEUR)).GET().build();
//         try {
//             HttpResponse response = client.send()
//         }
        return null;
    }

    @Override
    public int createUtil(UtilisateurDTO util) {
        String json = null;
        try {
            /*
                Reconstruction d'un objet uitilisateur DTO à partir d'un string
                UtilisateurDTO = objectMapper.reader(UtilisateurDTO.class).readValue(json);

                Reconstruction d'une liste d'UtilisateurDTO à partir d'un String JSON

                objectMapper.readValue(json,objectMapper.getTypeFactory().constructCollectionType(List.class,UtilisateurDTO.class));
             */
            json = objectMapper.writeValueAsString(util);
            HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(URI_SERVICE+UTILISATEUR)).
                    header("Content-type","application/json").POST
                    (HttpRequest.BodyPublishers.ofString(json)).build();
            HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode()==201){
                String []location = response.headers().firstValue("location").get().split("/");
                return Integer.parseInt(location[location.length-1]);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnexpectedError("Creation d'utilisateur Impossible");
    }


    @Override
    public Collection<UtilisateurDTO> getUtilisateursDisponiblesPour(int idRdv, int idCreneau) {
        return null;
    }


}
