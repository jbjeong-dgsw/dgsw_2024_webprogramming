package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.domain.Reply;
import kr.hs.dgsw.simple.domain.Writing;
import kr.hs.dgsw.simple.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/writing")
public class WritingController {

    private final WritingService writingService;

    @GetMapping("")
    public Page<Writing> list(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber) {

        return writingService.list(pageNumber);
    }

    @GetMapping("/{idx}")
    public Writing get(@PathVariable(value = "idx") int idx) {
        return writingService.get(idx);
    }

    @DeleteMapping("/{idx}")
    public void delete(@PathVariable(value = "idx") int idx) {
        writingService.delete(idx);
    }

    @PostMapping("")
    public Writing add(@RequestBody Writing writing) {
        return writingService.add(writing);
    }

    @PutMapping("")
    public Writing update(@RequestBody Writing writing) {
        return writingService.update(writing);
    }

    @PostMapping("/reply")
    public Reply addReply(@RequestBody Reply reply) {
        return writingService.addReply(reply);
    }

}
