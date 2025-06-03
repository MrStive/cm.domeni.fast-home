package cm.domeni.fast_home.api;

import cm.domeni.fast_home.dto.DemoDTO;
import cm.domeni.fast_home.service.DemoService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoResource implements DemoApi {
  private final DemoService demoService;

  @Override
  public ResponseEntity<List<DemoDTO>> fetchAllDemo() {
    return ResponseEntity.ok(demoService.fetchAllDemos());
  }

  @Override
  public ResponseEntity<UUID> createDemo(DemoDTO demoDTO) {
    UUID createdDemoId = demoService.createDemo(demoDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdDemoId);
  }
}
