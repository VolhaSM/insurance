package insurance.service;

import insurance.model.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JSONPolicyService {


    private final PersonalPoliceRepo personalPoliceRepo;


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
