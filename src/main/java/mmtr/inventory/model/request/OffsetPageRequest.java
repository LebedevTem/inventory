package mmtr.inventory.model.request;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class OffsetPageRequest implements Pageable {
  private final int limit;
  private final long offset;
  private final Sort sort;

  public OffsetPageRequest(int limit, long offset, Sort sort) {
    this.limit = limit;
    this.offset = offset;
    this.sort = sort;
  }

  public OffsetPageRequest(int limit, long offset) {
    this(limit, offset, Sort.unsorted());
  }

  public OffsetPageRequest(int limit, long offset, String sortBy, String sortDir) {
    this(limit, offset, Sort.by(new Sort.Order(Sort.Direction.fromString(sortDir), sortBy)));
  }

  @Override
  public boolean isPaged() {
    return true;
  }

  @Override
  public int getPageNumber() {
    return -1;
  }

  @Override
  public int getPageSize() {
    return limit;
  }

  @Override
  public long getOffset() {
    return offset;
  }

  @Override
  public Sort getSort() {
    return sort;
  }

  @Override
  public Pageable next() {
    return new OffsetPageRequest(limit, limit + offset, sort);
  }

  @Override
  public Pageable previousOrFirst() {
    long newOffset = Math.max(0, offset - limit);
    return new OffsetPageRequest(limit, newOffset, sort);
  }

  @Override
  public Pageable first() {
    return new OffsetPageRequest(limit, 0, sort);
  }

  @Override
  public boolean hasPrevious() {
    return offset > 0;
  }
}
