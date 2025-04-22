package com.unicomer.test.domain.feriado;

import java.util.Objects;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Getter
@Setter
@Table(name = "feriado")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Feriado {

	@Id
	@Column(name = "feriado_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20, unique = false, nullable = false)
	private String title;

	@Column(length = 20, unique = false, nullable = false)
	private String type;

	@Column(length = 20, unique = false, nullable = false)
	private int inalienable;

	@Column(length = 20, unique = false, nullable = false)
	private String extra;

	@Builder
	private Feriado(Integer id, String title, String type, int inalienable, String extra) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.inalienable = inalienable;
		this.extra = extra;
	}

	  @Override
	    public boolean equals(Object o) {
	        return o instanceof Feriado other && Objects.equals(this.id, other.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.id);
	    }

}
