package insurance.service;

import insurance.dto.PersonalPolicyDTO;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JSONPolicyService {


    private final PersonalPolicyService personalPolicyService;


    public JSONObject getJsonObject(int policeId) {


        PersonalPolicyDTO pp = personalPolicyService.findPoliceById(policeId);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("police", pp);

        try
                (FileWriter fileWriter = new FileWriter("data.json")) {

            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
