package tech.cassandre.trading.bot.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import tech.cassandre.trading.bot.util.java.EqualsBuilder;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

/**
 * DTO representing user information.
 */
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
@SuppressWarnings("checkstyle:VisibilityModifier")
public class UserDTO {

    /** User ID (usually username). */
    String id;

    /** The accounts owned by the user. */
    @Singular
    Map<String, AccountDTO> accounts;

    /** Information timestamp. */
    ZonedDateTime timestamp;

    /**
     * Getter timestamp.
     *
     * @return timestamp
     */
    public final ZonedDateTime getTimestamp() {
        return Objects.requireNonNullElseGet(timestamp, ZonedDateTime::now);
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserDTO that = (UserDTO) o;
        return new EqualsBuilder()
                .append(this.id, that.id)
                .isEquals();
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

}
