package com.sunway.cms.dto.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderParticular {

    private String foodName;

    private Integer quantity;

}
