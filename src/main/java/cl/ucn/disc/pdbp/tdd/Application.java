/*
 * MIT License
 *
 * Copyright (c) [2020.] [Wilber Mauricio Navarro Moreira]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cl.ucn.disc.pdbp.tdd;

import cl.ucn.disc.pdbp.tdd.model.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.json.JavalinJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public final class Application {
    /**
     * The logger.
     */
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * Private constructor.
     */
    private Application(){
        //nothing here.
    }

    /**
     * The main entry.
     *
     * @param args from console.
     */
    public static void main(String[] args) {

        // Gson configuration.
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        JavalinJson.setFromJsonMapper(gson::fromJson);
        JavalinJson.setToJsonMapper(gson::toJson);

        // The Javalin application.
        log.debug("Starting JavaLin ..");
        Javalin javalin = Javalin.create(config -> {

            //enable extensive development logging for http and websocket.
            //config.enableDevLogging();

            // Measure the time.
            config.requestLogger((((ctx, executionTimeMs) -> {
                log.info("server {} in {} ms.", ctx.fullUrl(),executionTimeMs);
                ctx.header("Server-Timing","total;dur="+ executionTimeMs);
            })));

            // Enable routes helper.
            config.registerPlugin(new RouteOverviewPlugin("/routes"));

        //Define the routes.
        }).routes(()->{

            //The version.
            ApiBuilder.path("v1", ()->{

                // /fichas.
                ApiBuilder.path("fichas",()->{

                    // /Get -> /fichas.
                    ApiBuilder.get(ApiRestEndpoints::getAllFichas);

                    // Get -> /fichas/find/{query}.
                    ApiBuilder.path("find/:query",()->{
                        ApiBuilder.get(ApiRestEndpoints::findFichas);
                    });

                    // Get -> /fichas/{numeroFicha}/controles.
                    ApiBuilder.path(":numeroFicha",()->{

                        ApiBuilder.path("controles",()->{

                            ApiBuilder.get(ApiRestEndpoints::getControlesDeFicha);

                        });

                    });

                    // Get -> /fichas/{numeroFicha}/persona.
                    ApiBuilder.path(":numeroFicha",()->{

                        ApiBuilder.path("persona",()->{

                            ApiBuilder.get(ApiRestEndpoints::getPersonaDeFicha);

                        });

                    });

                });
                // /personas.
                ApiBuilder.path("personas",()->{

                    // /Get -> /personas.
                    ApiBuilder.get(ApiRestEndpoints::getAllPersonas);

                });
                ApiBuilder.path("personas?=pageSize",()->{

                    ApiBuilder.path(":size",()->{

                        ApiBuilder.path("&page=",()->{

                            ApiBuilder.path(":number",()->{

                                // /Get ->/personas?=pageSize{size}&page={number}.
                                //ApiBuilder.get(ApiRestEndpoints::getListadoPersonas);

                            });

                        });

                    });

                });

            });

        //Start the server at port 700.
        }).start(7000);
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            log.debug("Stopping the server ..");
            javalin.stop();
            log.debug("The end.");
        }));

        // A simple route to show time.
        javalin.get("/", ctx -> {
            //Show the date.
            ctx.result("The date: "+ ZonedDateTime.now());
        });

        // Personas.
        javalin.get("/person",ctx -> {

            // Create simply list.
            List<Persona> personas = Arrays.asList(
                    new Persona ("Andrea",
                            "Contreras",
                            "152532873",
                            "234 6768",
                            "569 56435447",
                            "Argentina 1234",
                            "correo@alumnos.ucn.cl"),

                    new Persona ("Camila",
                            "Reyes",
                            "216087402",
                            "234 6745",
                            "569 56439945",
                            "Angamos 1234",
                            "correo_apellido@alumnos.ucn.cl")
            );

            // Send the List.
            ctx.json(personas);

        });



    }













}
