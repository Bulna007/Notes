<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>New Job</title>
    </head>
    <body>
        <h2>New Job posting</h2>
        <form:form modelAttribute="newJobForm">
            <label for="jobTitle">Job Title:</label>
            <form:input path="jobTitle"/><br/>
            <label for="description">Description:</label>
            <form:input path="description"/><br/>
            <label for="organization">Organization:</label>
            <form:input path="organization"/><br/>
            <label for="experience">Experience:</label>
            <form:input path="experience"/><br/>
            <label for="profession">Profession:</label>
            <form:select path="profession" onchange="populateSpecializations(this);">
                <form:option value="0" label="select"/>
                <form:options items="${professions}" itemValue="professionId" itemLabel="professionName"/>
            </form:select><br/>
            <label for="specialization">Specialization:</label>
            <form:select path="specialization">
            </form:select><br/>
            <button type="submit">Post Job</button>
        </form:form>
        <script type="text/javascript">
            const baseURI = "http://localhost:8080/job/";

            function populateSpecializations(selProfession) {
                const professionId = selProfession.value;
                var selSpecialization =  document.getElementById("specialization");
                var httpReq = null;

                if(professionId == 0) {
                    resetSpecializationSelect();
                    return;
                }
                var uri = baseURI+ professionId+"/specializations";
                httpReq = new XMLHttpRequest();
                httpReq.onreadystatechange = function() {
                   if(httpReq.readyState == 4 && httpReq.status == 200) {
                        console.log(httpReq.responseText);
                        resetSpecializationSelect();
                        var specializations = JSON.parse(httpReq.responseText);
                        specializations.forEach(function(specialization) {
                            var option = document.createElement("option");
                            option.value = specialization.specializationId;
                            option.label = specialization.specializationName;
                            selSpecialization.appendChild(option);
                        });
                   }
                };
                httpReq.open("GET", uri, true);
                httpReq.send();
            }

            function resetSpecializationSelect() {
                var selSpecialization = document.getElementById("specialization");
                while(selSpecialization.options.length > 0) {
                    selSpecialization.remove(0);
                }
            }

        </script>
    </body>
</html>