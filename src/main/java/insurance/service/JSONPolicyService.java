package insurance.service;

import insurance.pojo.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@Service

public class JSONPolicyService {

    @Autowired
    PersonalPoliceRepo personalPoliceRepo;


    public JSONObject getJsonObject(Integer policeId) {


        Optional <PersonalPolicy> pp = personalPoliceRepo.findById(policeId);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("police", pp);

        try {
            FileWriter fileWriter = new FileWriter("data.json");

            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
