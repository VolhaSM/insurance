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

    public void getJsonObject(long policeId, String filePath) {

        PersonalPolicyDTO policy = personalPolicyService.findPoliceById(policeId);
        JSONObject jsonObject = new JSONObject();
        if (policy.getId() != null) {
            jsonObject.put("police", policy);
        } else throw new IllegalArgumentException("Not Found");

        try (FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
