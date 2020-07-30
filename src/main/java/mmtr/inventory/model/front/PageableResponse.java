package mmtr.inventory.model.front;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.Collection;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageableResponse<T> {

  private Collection<T> items;
  private Long total;

  public PageableResponse(Page<T> page) {
    this.items = page.getContent();
    this.total = page.getTotalElements();
  }
}
