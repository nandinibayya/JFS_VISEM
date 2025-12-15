document.addEventListener("DOMContentLoaded", function () {

    const subjects = document.querySelectorAll(".subject");
    const totalBox = document.getElementById("total");
    const form = document.getElementById("regForm");
    const resultBox = document.getElementById("resultBox");

    // Update total on checkbox selection
    subjects.forEach(chk => {
        chk.addEventListener("change", () => {
            let total = 0;
            subjects.forEach(s => {
                if (s.checked) total += parseInt(s.value);
            });
            totalBox.textContent = "₹" + total;
        });
    });

    // Submit form → show details below
    form.addEventListener("submit", function (e) {
        e.preventDefault();

        let name = document.getElementById("name").value;
        let selectedSubjects = [];
        let total = 0;

        subjects.forEach((s, index) => {
            if (s.checked) {
                let text = s.parentElement.innerText.trim();
                selectedSubjects.push(`${selectedSubjects.length + 1}. ${text}`);
                total += parseInt(s.value);
            }
        });

        resultBox.style.display = "block";
        resultBox.innerHTML = `
            <h3>Registration Successful!</h3>
            <p><b>Student Name:</b> ${name}</p>
            <p><b>Selected Subjects:</b><br> ${selectedSubjects.join("<br>")}</p>
            <p><b>Total Fee:</b> ₹${total}</p>
        `;
    });
});
